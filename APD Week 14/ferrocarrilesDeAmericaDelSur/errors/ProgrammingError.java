package errors;
public class ProgrammingError extends RailwaySystemError {
	public ProgrammingError(String message) {
		super("[Programming error] " + message);
	}
}
	