package namfo.use_case.LoadCreatureUseCase;

public interface LoadCreatureOutputBoundary {
    void prepareSuccessView(LoadCreatureOutputData data);
    void prepareFailView(LoadCreatureOutputData data);
}
