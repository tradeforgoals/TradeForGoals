Build image: docker build -t tradeforgoals.azurecr.io/tradeforgoals/backend .
Run image: docker run -it --rm -p 8083:8080 tradeforgoals.azurecr.io/tradeforgoals/backend
View files image: docker exec -t -i {containerId} /bin/bash