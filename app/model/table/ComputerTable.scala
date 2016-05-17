package model.table

import model.{Computer, Room}
import slick.driver.MySQLDriver.api._
import slick.lifted.{ForeignKeyQuery, ProvenShape}

/**
  * Computer table map with Slick
  *
  * @param tag
  */
class ComputerTable(tag: Tag) extends Table[Computer](tag, "computer") {

  // Other columns/attributes
  def name = column[Option[String]]("name")

  // Room foreign key
  def room: ForeignKeyQuery[RoomTable, Room] = foreignKey("room_id", roomId, TableQuery[RoomTable])(_.id, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Cascade)

  // All tables need the * method with the type that it was created the table.
  override def * : ProvenShape[Computer] =
    (ip, name, mac, SSHUser, SSHPassword, description, roomId) <>(Computer.tupled, Computer.unapply)

  // PrimaryKey
  def ip = column[String]("computer.ip", O.PrimaryKey)

  def mac = column[Option[String]]("mac")

  def SSHUser = column[String]("ssh_user")

  def SSHPassword = column[String]("ssh_password")

  def description = column[Option[String]]("description")

  def roomId = column[Option[Long]]("room_id")
}