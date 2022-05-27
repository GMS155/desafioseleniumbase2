start java -jar selenium-server-standalone-3.141.59.jar -port 8888 -role hub -hubConfig HubConfig.json
start java -jar -Dwebdriver.chrome.driver="chromedriver.exe" -Dwebdriver.gecko.driver="geckodriver.exe" -Dwebdriver.edge.driver="msedgedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -id node_1 -nodeConfig NodeDefaultConfig.json
