package squ.tab;

public class st {
    String[][] tabStrings=new String[10][10];
    public st(){
        InitialisationTab(tabStrings);
    }
    public String[][] getTabStrings() {
        return tabStrings;
    }
    public void setTabStrings(String[][] tabStrings) {
        this.tabStrings = tabStrings;
    }

    public static void InitialisationTab(String[][] tabStrings){
        for( int i = tabStrings.length-1;i>=0;i--){
            for( int j = tabStrings.length-1;j>=0;j--){
                tabStrings[i][j]="[   ]";
            }
        }
    }

}
