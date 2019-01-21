#!/bin/sh

curl -w "\n" \
-H "Accept: application/json" \
-F "deployment-name=qrreader-0.1" \
-F "enable-duplicate-filtering=false" \
-F "deploy-changed-only=falses" \
-F "qrreader.bpmn=@qrreader.bpmn" \
-F "qrreader.html=@qrreader.html" \
http://localhost:8080/engine-rest/deployment/create