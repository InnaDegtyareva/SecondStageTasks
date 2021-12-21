package hardcore.listsofvalues;

public enum GPUType {
    NVIDIA_TESLA_K80 {
        public String toString() {
            return "NVIDIA_TESLA_K80";
        }
    },
    NVIDIA_TESLA_P100 {
        public String toString() {
            return "NVIDIA_TESLA_P100";
        }
    },
    NVIDIA_TESLA_P4 {
        public String toString() {
            return "NVIDIA_TESLA_P4";
        }
    },
    NVIDIA_TESLA_V100 {
        public String toString() {
            return "NVIDIA_TESLA_V100";
        }
    },
    NVIDIA_TESLA_T4 {
        public String toString() {
            return "NVIDIA_TESLA_T4";
        }
    }
}

