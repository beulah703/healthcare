package spring.mail.orm.model;


	

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "otp_status")
	public class OTPVerify {
		@Id
		@Column(name = "uname")
		private String username;
		@Column(name = "otp")
		private String otp;
		@Column(name = "status")
		private String status;

		public OTPVerify(String username, String otp, String status) {

			this.username = username;
			this.otp = otp;
			this.status = status;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getOtp() {
			return otp;
		}

		public void setOtp(String otp) {
			this.otp = otp;
		}

		public String getstatus() {
			return status;
		}

		public void setstatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return username + " " + otp + " " + status;
		}

		public OTPVerify() {
			super();
		}

	}


