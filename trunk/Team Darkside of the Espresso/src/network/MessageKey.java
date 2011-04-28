/*
 * The MessageKey Enumeration.
 */

package network;

/**
 * The MessageKey Enumeration.
 * 
 * @author Fraser P. Newton
 * @version 1.0.0
 */
public enum MessageKey {

	/** The NULL message. */
	NULL,
	/** The ECHO message. */
	ECHO,
	/** The SUCCESS. */
	SUCCESS,
	/** The FAILURE message. */
	FAILURE,
	/** The DISCONNECT message. */
	DISCONNECT,
	/** The DB_GETUSERID message. */
	DB_GETUSERID,
	/** The DB_GETALLUSERS message. */
	DB_GETALLUSERS,
	/** The DB_CREATEUSER message. */
	DB_CREATEUSER,
	/** The DB_UPDATEUSER message. */
	DB_UPDATEUSER,
	/** The DB_DELETEUSER message. */
	DB_DELETEUSER,
	/** The TERM message. */
	TERM
}
