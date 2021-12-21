package hurtMePlenty.listsofvalues;

public enum DatacenterLocation {
    IOWA {
        public String toString() {
            return "us-central1";
        }
    },
    BELGIUM {
        public String toString() {
            return "europe-west1";
        }
    },
    LONDON {
        public String toString() {
            return "europe-west2";
        }
    },
    FRANKFURT {
        public String toString() {
            return "europe-west3";
        }
    }
}
