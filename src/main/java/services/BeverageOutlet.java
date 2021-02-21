package services;

import beverage.Beverage;
import exceptions.InsufficientIngredientException;
import exceptions.SystemNotIdleException;
import ingredients.Ingredient;

public class BeverageOutlet {
    private BeverageOutletState beverageOutletState;
    private int outletNumber;

    /**
     * @param beverageOutletState to define if the particular outlet is busy idle or damaged
     * @param outletNumber        to define the number of outlet if it is 1,2 or 3
     * @throws IllegalArgumentException in case when outlet number is less than or equal to 0 or state passed is null
     */
    public BeverageOutlet(BeverageOutletState beverageOutletState, int outletNumber) throws IllegalArgumentException {
        if (beverageOutletState == null || outletNumber <= 0)
            throw new IllegalArgumentException();
        this.beverageOutletState = beverageOutletState;
        this.outletNumber = outletNumber;
    }

    /**
     * @param beverageOutletState to change the state of beverage outlet
     * @throws IllegalArgumentException in case when state passed in param is null
     */
    public void setBeverageOutletState(BeverageOutletState beverageOutletState) throws IllegalArgumentException {
        if (beverageOutletState == null)
            throw new IllegalArgumentException();
        this.beverageOutletState = beverageOutletState;
    }

    /**
     * @param beverage which is to be dispatched by the particular outlet
     * @throws IllegalArgumentException in case where the beverage passed as argument is null
     */
    public void dispatchBeverage(Beverage beverage) throws IllegalArgumentException {
        if (beverage instanceof Ingredient) {
            System.out.println(beverage.getBeverageDescription() + " is prepared at outlet " + outletNumber);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @param beverageType beverage is to be produced by the function
     * @throws InsufficientIngredientException in case where the quantity is not sufficient
     * @throws IllegalArgumentException        a nested exception thrown by Production service class
     * @throws SystemNotIdleException          in case when the state of the current outlet is not IDLE
     * @implNote It first checks if the beverage state is not Idle then it throws OutletNotIdle Exception
     * This all happens in synchronized so context switching inside if won't be possible. Then it produces the beverage
     * and dispatch the beverage from outlet.
     */
    public void prepareBeverage(BeverageType beverageType) throws InsufficientIngredientException, IllegalArgumentException, SystemNotIdleException {
        if (beverageType == null)
            throw new IllegalArgumentException();
        synchronized (this) {
            if (beverageOutletState != BeverageOutletState.IDLE) {
                throw new SystemNotIdleException(outletNumber + " outlet is busy currently producing another beverage");
            }
            setBeverageOutletState(BeverageOutletState.BUSY);
        }
        try {
            Beverage beverage = ProductionService.produceBeverage(beverageType);
            dispatchBeverage(beverage);
        } finally {
            setBeverageOutletState(BeverageOutletState.IDLE);
        }
    }
}
