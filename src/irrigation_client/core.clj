(ns irrigation-client.core
  (:gen-class)
  (:require [clojurewerkz.machine-head.client :as mh]))
(def ^:const topic "mqtt/hackaton/enviar/id1")
(def ^:const topicReceber "mqtt/hackaton/receber/id1")
(defn start
  [conn]
  (mh/subscribe conn {topicReceber 0} (fn [^String topic _ ^bytes payload]
                                   (println (String. payload "UTF-8"))))
)
(defn -main
  [& args]
  (let [conn (mh/connect "tcp://127.0.0.1:1883")]
    (start conn)
    (mh/publish conn topic "-23.5505199;-46.6333094")
    ))
