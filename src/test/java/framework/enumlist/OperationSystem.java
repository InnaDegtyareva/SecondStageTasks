package framework.enumlist;

public enum OperationSystem {
    FREE_DEBIAN_CENTOS_COREOS_UBUNTU_OR_BYOL {
        public String toString() {
            return  "free";
        }
    },
    PAID_UBUNTU_PRO {
        public String toString() {
            return "ubuntu-pro";
        }
    },
    PAID_WINDOWS_SERVER {
        public String toString() {
            return "win";
        }
    },
    PAID_RED_HAT {
        public String toString() {
            return "rhel";
        }
    },
    PAID_SLES {
        public String toString() {
            return "sles";
        }
    },
    PAID_SQL_SERVER_STANDARD {
        public String toString() {
            return "sql-standard";
        }
    };
}
