package namfo.use_case.LoadCreatureUseCase;

import namfo.Entities.Creature;
import namfo.data_access.CreatureManagerDataAccessInterface;

public class LoadCreatureInteractor implements LoadCreatureInputBoundary{
    private LoadCreatureOutputBoundary loadCreaturePresenter;
    private CreatureManagerDataAccessInterface dataAccessInterface;


    public LoadCreatureInteractor(LoadCreatureOutputBoundary loadCreaturePresenter, CreatureManagerDataAccessInterface dataAccessInterface){
        this.loadCreaturePresenter = loadCreaturePresenter;
        this.dataAccessInterface = dataAccessInterface;
    }
    @Override
    public void loadCreatureExecute(LoadCreatureInputData load_creature_input_data) {
        int creature_index = load_creature_input_data.getCreatureIndex();
        Creature creature = dataAccessInterface.loadCreatureByIndex(creature_index);
        // Get creature simple stats and turn them into string double list

        LoadCreatureOutputData data = new LoadCreatureOutputData(creature.getName(), creature.getBorderColor(), creature.getAutoRoll(), creature.getAutoRollExpression(), creature.getImage(), creature.getEvents(), creature.getSimpleStats());
        loadCreaturePresenter.loadCreaturePrepareSuccessView(data);

    }

}
