package com.example.testapp;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Cell data
 */
public class CellInfoGather {

    private final TelephonyManager telephonyManager;

    /**
     * Configures Telephony Manager
     * @param context
     */
    public CellInfoGather(Context context)
    {
        telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    /**
     * Sorts out the GSM cells from all the other currently
     * connected cells
     * @return ArrayList of GSM cells
     */
    public ArrayList<CellInfoGsm> gsmCells()
    {
        ArrayList<CellInfoGsm> cellInfoGsms = new ArrayList<CellInfoGsm>();
        for(CellInfo cellInfo : allCells())
        {
            if(cellInfo instanceof CellInfoGsm)
            {
                cellInfoGsms.add((CellInfoGsm)cellInfo);
            }
        }
        return cellInfoGsms;
    }

    /**
     * Sorts out the WCDMA cells from all the other currently
     * connected cells
     * @return ArrayList of WCDMA cells
     */
    public ArrayList<CellInfoWcdma> wcdmaCells()
    {
        ArrayList<CellInfoWcdma> cellInfoWcdmas = new ArrayList<CellInfoWcdma>();
        for(CellInfo cellInfo : allCells())
        {
            if(cellInfo instanceof CellInfoWcdma)
            {
                cellInfoWcdmas.add((CellInfoWcdma)cellInfo);
            }
        }
        return cellInfoWcdmas;
    }

    /**
     *
     * @return List of all connected cells
     */
    public List<CellInfo> allCells()
    {
        return  telephonyManager.getAllCellInfo();
    }
}
