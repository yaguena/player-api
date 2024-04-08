
docker run --name mysql-server --network=my-network -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Brasil04 -d mysql:8

docker network create -d bridge my-network