nssm install SeleniumNode1 java -Dwebdriver.chrome.driver="chromedriver.exe" -Dwebdriver.edge.driver="MicrosoftWebDriver.exe" -Dwebdriver.gecko.driver="geckodriver.exe" -jar selenium-server.jar -role node -nodeConfig NodeDefaultConfig.json
nssm set SeleniumNode1 AppDirectory C:\Selenium Stoque
nssm set SeleniumNode1 DependOnService SeleniumHub
nssm start SeleniumNode1

nssm install SeleniumNode2 java -Dwebdriver.chrome.driver="chromedriver.exe" -Dwebdriver.edge.driver="MicrosoftWebDriver.exe" -Dwebdriver.gecko.driver="geckodriver.exe" -jar selenium-server.jar -role node -nodeConfig NodeDefaultConfig.json
nssm set SeleniumNode2 AppDirectory C:\Selenium Stoque
nssm set SeleniumNode2 DependOnService SeleniumHub
nssm start SeleniumNode2