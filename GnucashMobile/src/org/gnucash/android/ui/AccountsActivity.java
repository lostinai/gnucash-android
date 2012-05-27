/*
 * Written By: Ngewi Fet <ngewif@gmail.com>
 * Copyright (c) 2012 Ngewi Fet
 *
 * This file is part of Gnucash for Android
 * 
 * Gnucash for Android is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, contact:
 *
 * Free Software Foundation           Voice:  +1-617-542-5942
 * 51 Franklin Street, Fifth Floor    Fax:    +1-617-542-2652
 * Boston, MA  02110-1301,  USA       gnu@gnu.org
 */

package org.gnucash.android.ui;

import org.gnucash.android.R;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

/**
 * Displays the list of accounts and summary of transactions
 * @author Ngewi Fet <ngewif@gmail.com>
 *
 */
public class AccountsActivity extends SherlockFragmentActivity {
	
	private static final String FRAGMENT_ACCOUNTS_LIST = "accounts_list";

	static final int DIALOG_ADD_ACCOUNT = 0x01;
	
	protected static final String TAG = "AccountsActivity";

//	private AccountsDbAdapter mAccountsDbAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.activity_accounts);
        
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();      
        fragmentTransaction.add(R.id.fragment_container, new AccountsListFragment(), FRAGMENT_ACCOUNTS_LIST);
 
        fragmentTransaction.commit();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }

	public void onNewAccountClick(View v) {
		AccountsListFragment accountFragment = (AccountsListFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_ACCOUNTS_LIST);
		if (accountFragment != null)
			accountFragment.showAddAccountDialog();
	}

}