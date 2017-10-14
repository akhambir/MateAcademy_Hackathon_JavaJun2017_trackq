tomcat_path=/opt/tomcat/apache-tomcat-8.5.23
app_path=/opt/repo/MateAcademy_Hackathon_JavaJun2017_trackq
pid=$(ps axuw | grep ${tomcat_path} | grep -v grep | awk '{print $2}')
if [ "${pid}" ]; then
  eval "kill ${pid}"
fi
cd ${app_path}
git pull
mvn clean install
cp target/*.war ${tomcat_path}/webapps/
sh ${tomcat_path}/bin/startup.sh
