package db;

/**
 * Enum for the question types
 * 
 * @author thorsten
 */
public enum Type {
	Zahl {@Override public String toString() { return "1"; } },
	Text {@Override public String toString() { return "2"; } },
	Auswahl {@Override public String toString() { return "3"; } },
}
