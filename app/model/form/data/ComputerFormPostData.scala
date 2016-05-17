package model.form.data

/**
  * Created by camilo on 7/05/16.
  */
case class ComputerFormPostData(
                             ip: String,
                             name: String,
                             SSHUser: String,
                             SSHPassword: String,
                             description: String,
                             roomID: Long
                           )