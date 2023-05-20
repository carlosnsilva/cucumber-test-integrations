#!/bin/sh
echo "Parando o banco de dados"
sleep 3
docker-compose -f docker-compose.yml down