## PROEJECT 

**Referencia:** https://github.com/mongodb/mongodb-atlas-kubernetes

Primero deberá de iniciar sesión al OpenShift

```shell
oc login -u ${OCP4_USER} -p ${OCP4_PASSWORD} ${OCP4_MASTER_API}
```

Crear un nuevo proyecto

```shell
oc new-project mongodb-atlas-system
```

Instalar el Operador: **Operator: MongoDB Atlas Operator**

Declarar variables de entorno

```shell
soruce ocp4.config
```

Crear un secreto de clave API de Atlas

```shell
oc create secret generic mongodb-atlas-operator-api-key \
    --from-literal="orgId=${ORG_ID}" \
    --from-literal="publicApiKey=${PUBLIC_APIKEY}" \
    --from-literal="privateApiKey=${PRIVATE_APIKEY}" \
    -n mongodb-atlas-system
```

```shell
oc label secret mongodb-atlas-operator-api-key \
    atlas.mongodb.com/type=credentials \
    -n mongodb-atlas-system
```

Crear un recurso personalizado **AtlasProject**

```yaml
apiVersion: atlas.mongodb.com/v1
kind: AtlasProject
metadata:
  name: wom-k8s-project
  namespace: mongodb-atlas-system
spec:
  maintenanceWindow: {}
  name: Test Atlas Operator Project
  projectIpAccessList:
    - comment: IP address for Application Server A
      ipAddress: 0.0.0.0
  withDefaultAlertsSettings: true
```

Crear una contraseña de usuario de base de datos

```shell
oc create secret generic atlas-password \
    --from-literal="password=${ALTAS_PASSWORD}" \
    -n mongodb-atlas-system
```

```shell
oc label secret atlas-password \
    atlas.mongodb.com/type=credentials \
    -n mongodb-atlas-system
```

Crear un recurso personalizado **AtlasDatabaseUser**

```yaml
apiVersion: atlas.mongodb.com/v1
kind: AtlasDatabaseUser
metadata:
  name: atlas-user
  namespace: mongodb-atlas-system
spec:
  roles:
    - roleName: "readWriteAnyDatabase"
      databaseName: "admin"
  projectRef:
    name: wom-k8s-project
  username: womk8s
  passwordSecretRef:
    name: atlas-password
```

Crear un recurso personalizado **AtlasDeployment**

```yaml
apiVersion: atlas.mongodb.com/v1
kind: AtlasDeployment
metadata:
  name: wom-k8s-cluster
  namespace: mongodb-atlas-system
spec:
  projectRef:
    name: wom-k8s-project
  deploymentSpec:
    name: "Cluster0"
    providerSettings:
      instanceSizeName: M0
      providerName: TENANT
      regionName: US_EAST_1
      backingProviderName: AWS
```

Crear projecto de pruebas

```shell
oc new-project test
```

Desplegar aplicación

```shell
oc new-app --name wom-app \
  java:11~https://github.com/luisfalero/mongodb.git \
  --as-deployment-config \
  -n test
```

```shell
oc create secret generic mongodb-api-key \
    --from-literal="mongodb-uri=${MONGODB_URI}" \
    --from-literal="mongodb-database=${MONGODB_DATABASE}" \
    -n test
```

```shell
oc -n test set env dc/wom-app --from secret/mongodb-api-key
```

Exponer ruta en HTTPS

```shell
oc -n test create route edge --service=wom-app --port=8080
```
