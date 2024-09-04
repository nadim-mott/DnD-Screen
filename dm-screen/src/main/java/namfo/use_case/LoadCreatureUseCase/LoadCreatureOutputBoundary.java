package namfo.use_case.LoadCreatureUseCase;

public interface LoadCreatureOutputBoundary {
    void loadCreaturePrepareSuccessView(LoadCreatureOutputData data);
    void loadCreaturePrepareFailView(LoadCreatureOutputData data);
}
