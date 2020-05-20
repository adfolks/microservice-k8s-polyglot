FROM ubuntu:latest
WORKDIR /app
COPY . .
RUN apt-get update
RUN apt install python3-pip --assume-yes
RUN pip3 install confluent-kafka
ENTRYPOINT [ "python3", "producer_service.py","ecom-sku-stock" ]
