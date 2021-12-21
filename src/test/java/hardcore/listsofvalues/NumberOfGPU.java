package hardcore.listsofvalues;

public enum NumberOfGPU {
    NULL {
        public String toString() {
            return "0";
        }
    },
    ONE {
        public String toString() {
            return "1";
        }
    },
    TWO {
        public String toString() {
            return "2";
        }
    },
    FOUR {
        public String toString() {
            return "4";
        }
    }
}
