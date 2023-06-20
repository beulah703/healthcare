<div >
	<nav class="navbar navbar-expand-lg navbar-lignt bg-success text-white">
		<a class="navbar-brand text-white" href="./">Doctor Appointment
			System</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<ul class="nav nav-pills flex-row mb-auto">
			<li class="nav-item"><a href="./" class="nav-link"
				aria-current="page">Dashboard</a></li>
			<li><a href="./specialization" class="nav-link">Specialization</a></li>
			<li><a href="./doctors" class="nav-link">Doctors</a></li>

			<li class="nav-item">

				<p class="nav-link" href="" id="appointmentsLink">Appointments</p>
				<div class="dropdown-menu"  aria-labelledby="appointmentsLink">

					<a class="dropdown-item co" href="./appointments">Booked
						Appointments</a> <a class="dropdown-item co" href="./newappointment">New
						Appointments</a>

				</div>
			</li>
			<li><a href="./getpatient" class="nav-link">Patient Profile
					Update</a></li>
			<li><a href="./adminpay" class="nav-link">Payments</a></li>
			
		</ul>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

			</ul>
			<ul class="navbar-nav mr-right">
				<li class="nav-right dropdown">
					<div class="dropdown">
						<button
							class="btn btn-secondary dropdown-toggle bg-gradient-success "
							type="button" id="dropdownMenuButton"
							style="background: #e9ecef; color: black" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">Admin</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

							<a class="dropdown-item" href="./change">change Password</a> <a
								class="dropdown-item" href="../admin/settings">Settings</a> <a
								class="dropdown-item" href="../">Logout</a>

						</div>
					</div>
				</li>
			</ul>
		</div>
	</nav>
</div>
