cd ./identity
docker build -t rolandsall24/identity-info-service:1.0.0-env-local .

cd ../
cd ./catalog

docker build -t rolandsall24/catalog-info-service:1.0.0-env-local .

cd ../
cd ./item-rating

docker build -t rolandsall24/items-rating-service:1.0.0-env-local .

cd ../
cd ./items-info

docker build -t rolandsall24/items-info-service:1.0.0-env-local .

cd ../
cd ./discovery-server



cd ../
cd ./basket

docker build -t rolandsall24/basket-service:1.0.0-env-local .
