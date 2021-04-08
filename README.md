# ComparaJá - Code Challenge

Local DB

`docker pull postgres`

`docker run -d --name dev-postgres -e POSTGRES_PASSWORD=devpass -v z:/postgres_data/:/var/lib/postgresql/data -p 5432:5432 postgres`
