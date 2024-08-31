package namfo.use_case.LoadCreatureUseCase;

public class LoadCreatureInputData {
    final private int creature_index;
    public LoadCreatureInputData(int creature_index){
        // LMAO I could I have just passed in an integer. Clean Architecture moment
        this.creature_index = creature_index;
    }

    public int getCreatureIndex(){
        return this.creature_index;
    }
}
