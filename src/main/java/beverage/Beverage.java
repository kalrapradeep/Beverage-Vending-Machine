package beverage;


import services.BeverageType;

public abstract class Beverage {
    private BeverageType beverageType;

    /**
     * @param beverageType to construct the beverage with its type to track name
     */
    protected Beverage(BeverageType beverageType) {
        this.beverageType = beverageType;
    }

    /**
     * @return get the main beverage name
     */
    public String getBeverageDescription() {
        return beverageType.toString();
    }

    /**
     * @return To get the beverage type enum
     */
    public BeverageType getBeverageType() {
        return beverageType;
    }

    /**
     * @param beverageType To set the beverageType enum
     */
    public void setBeverageType(BeverageType beverageType) {
        this.beverageType = beverageType;
    }
}
