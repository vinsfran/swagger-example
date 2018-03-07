#!/bin/bash
docker run -d -t \
        --name swagger-example \
        -v /opt/apps/swagger-example:/src \
        -w /src \
        -p 9002:8080 \
        --dns 192.168.129.111 \
        --dns-search asuncion.gov.py \
        devapps.asuncion.gov.py:5000/asu/maven:3.3.9 \
        mvn spring-boot:run
