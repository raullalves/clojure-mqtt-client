(defproject irrigation-client "0.1.0-SNAPSHOT"
  :description "Irrigation MQTT Client for Hackaton"
  :url "https://github.com/raullalves/clojure-mqtt-client"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clojurewerkz/machine_head "1.0.0"]]
  :main ^:skip-aot irrigation-client.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
