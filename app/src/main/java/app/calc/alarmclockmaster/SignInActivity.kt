    package app.calc.alarmclockmaster

  

            txtSignRecoveryPassword.setOnClickListener {
                val intent = Intent(this, RecoveryEmailCode::class.java)
                startActivity(intent)
            }

            txtSignRegistration.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }

            btnSignIn.setOnClickListener {
                if (edtSignEmail.text.toString().isEmpty()){
                    edtSignEmail.error = "Emailni kiriting"
                }
                else if(edtSignPassword.text.toString().isEmpty()){
                    edtSignPassword.error = "Parolni kiriting"
                }
                else if (edtSignPassword.text.toString().length < 4){
                    edtSignPassword.error = "Parol kamida 4 ta belgidan iborat bo'lishi kerak"
                }
                else {

                    signProgress.visibility = ProgressBar.VISIBLE
                    btnSignIn.visibility = Button.INVISIBLE

                    val signin = SignIn(
                        edtSignEmail.text.toString(),
                        edtSignPassword.text.toString()
                    )

                    val signIn: Call<SignIn> = ApiClient.userService.signIn(signin)
                    signIn.enqueue(object : retrofit2.Callback<SignIn> {
                        override fun onResponse(call: Call<SignIn>, response: retrofit2.Response<SignIn>) {
                            if (response.code() == 200){

                                signProgress.visibility = ProgressBar.INVISIBLE
                                btnSignIn.visibility = Button.VISIBLE

                                val user = response.body()
                                if (user != null){
                                    val intent = Intent(this@SignInActivity,ClockActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }

                            if (response.code() == 400){
                                json = gson.fromJson(response.errorBody()?.charStream(), JsonObject::class.java)
                                val error = json?.get("error")?.asString

                                signProgress.visibility = ProgressBar.INVISIBLE
                                btnSignIn.visibility = Button.VISIBLE

                                if (error == "password is incorrect"){
                                    edtSignPassword?.error = "Parol noto'g'ri"
                                }
                                if(error == "email is incorrect"){
                                    edtSignEmail?.error = "Bunday pochta mavjud emas "
                                } else{
                                    if(error == "email is not verified"){
                                        AlertDialog.Builder(this@SignInActivity)
                                            .setTitle("Hisobingizni tasdiqlang !")
                                            .setMessage("Hisobingiz tasdiqlanmagan. Tasdiqlash uchun kodni kiriting")
                                            .setPositiveButton("OK"){dialog, which ->
                                                dialog.dismiss()
                                            }
                                            .show()
                                    }
                                }
                            }
                            if (response.code() == 401){

                                signProgress.visibility = ProgressBar.INVISIBLE
                                btnSignIn.visibility = Button.VISIBLE

                                json = gson.fromJson(response.errorBody()?.charStream(), JsonObject::class.java)
                                val error = json?.get("error")?.asString
                                if (error == "user is blocked") {
                                    AlertDialog.Builder(this@SignInActivity)
                                        .setTitle("Hisobingizni Bloknagan !")
                                        .setMessage("Hisobingiz bloklangan. Iltimos Administrator bilan bog'laning !")
                                        .setPositiveButton("OK") { dialog, which ->
                                            dialog.dismiss()
                                        }
                                        .show()
                                }
                            }
                        }
                        override fun onFailure(call: Call<SignIn>, t: Throwable) {
                            Toast.makeText(this@SignInActivity,"Nimadir xato ketti", Toast.LENGTH_SHORT).show()
                        }
                    })

                }
            }
        }
}