#!/bin/sh
echo "Initiating a call between 201 and 202 as 201"
curl -k -T curlcommand.sh https://sipxtest.sipxtest.net:6666/callcontroller/201/202
sleep 20
echo "Query call setup progress for call between 201 and 202 as 201"
curl -k https://sipxtest.sipxtest.net:6666/callcontroller/201/202