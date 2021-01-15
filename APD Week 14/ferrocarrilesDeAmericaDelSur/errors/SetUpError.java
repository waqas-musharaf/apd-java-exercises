package errors;
public class SetUpError extends RailwaySystemError {
	public SetUpError(String message) {
		super("[Set up error] " + message);
	}
}
