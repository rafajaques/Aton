package model

import java.sql.Timestamp

/**
  * POJO with the basic SSH Order information (Used by the SSH Order DAO, Service and Controller)
  * @author Camilo Sampedro <camilo.sampedro@udea.edu.co>
  */
case class SSHOrder(
                     id: Long,
                     sentDatetime: Timestamp,
                     superUser: Boolean,
                     interrupt: Boolean,
                     command: String,
                     webUser: String) {
  def this(sentDatetime: Timestamp, superUser: Boolean, interrupt: Boolean, command: String, username: String) =
    this(0, sentDatetime, superUser, interrupt, command, username)

  def this(sentDatetime: Timestamp, superUser: Boolean, command: String) = this(0, sentDatetime, superUser, false, command, "")

  def this(sentDatetime: Timestamp, command: String, webUser: String) = this(0, sentDatetime, false, false, command, webUser)
}
