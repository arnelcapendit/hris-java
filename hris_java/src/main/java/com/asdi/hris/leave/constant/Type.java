package com.asdi.hris.leave.constant;

public enum Type {

	sick {
		@Override
		public String toString() {
			return "Sick";
		}
	},

	vacation {
		@Override
		public String toString() {
			return "Vacation";
		}
	},

	maternity {
		@Override
		public String toString() {
			return "Maternity";
		}
	},

	paternity {
		@Override
		public String toString() {
			return "Paternity";
		}
	},

	parental {
		@Override
		public String toString() {
			return "Parental";
		}
	},

	service_incentive {
		@Override
		public String toString() {
			return "Service_incentive";
		}
	},

	rehabilitation {
		@Override
		public String toString() {
			return "Rehabilitation";
		}
	},

	study {
		@Override
		public String toString() {
			return "Study";
		}
	},

	marriage {
		@Override
		public String toString() {
			return "Marriage";
		}
	}
}
