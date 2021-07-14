package com.matthewchiborak.dndcharaterclienttester.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.matthewchiborak.dndcharacterclienttester.tests.CharacterCreationTest;
import com.matthewchiborak.dndcharacterclienttester.tests.DeleteTest;
import com.matthewchiborak.dndcharacterclienttester.tests.PlayingTests;
import com.matthewchiborak.dndcharacterclienttester.tests.UpdatingTest;

@RunWith(Suite.class)
@SuiteClasses({
	CharacterCreationTest.class,
	PlayingTests.class,
	UpdatingTest.class,
	DeleteTest.class
})
public class AllTests {

}
