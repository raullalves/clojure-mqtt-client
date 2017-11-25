(ns irrigation-client.core
  (:gen-class)
  (:require [clojurewerkz.machine-head.client :as mh]))
(def ^:const topic-send-info "irrigathon-send")
(def ^:const topic-receive-action "irrigathon-receive")
(defn start-receive-action
  [conn]
  (mh/subscribe conn {topic-receive-action 0} (fn [^String topic _ ^bytes payload]
                                   (println (String. payload "UTF-8"))))
)
(defn -main
  [& args]
  (let [conn (mh/connect "tcp://127.0.0.1:1883")]
    (start-receive-action conn)
    (mh/publish conn topic-receive-action "longitude, latitude")
    (Thread/sleep 100)
    (mh/disconnect conn)))