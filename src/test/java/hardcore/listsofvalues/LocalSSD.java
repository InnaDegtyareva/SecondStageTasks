package hardcore.listsofvalues;

public enum LocalSSD {
    NULL {
        public String toString() {
            return "0";
        }
    },
    ONE_X_375_GB {
        public String toString() {
            return "1x375 GB";
        }
    },
    TWO_X_375_GB {
        public String toString() {
            return "2x375 GB";
        }
    },
    THREE_X_375_GB {
        public String toString() {
            return "3x375 GB";
        }
    },
    FOUR_X_375_GB {
        public String toString() {
            return "4x375 GB";
        }
    },
    FIVE_X_375_GB {
        public String toString() {
            return "5x375 GB";
        }
    }
}
