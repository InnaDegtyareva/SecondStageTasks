package framework.enumlist;

public enum MachineClass {
    REGULAR {
        public String toString() {
           return "regular";
        }
    },
    PREEMPTIBLE {
        public String toString() {
          return "preemptible";
        }
    }
}
