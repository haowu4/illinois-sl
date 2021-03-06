/*******************************************************************************
 * University of Illinois/NCSA Open Source License
 * Copyright (c) 2010, 
 *
 * Developed by:
 * The Cognitive Computations Group
 * University of Illinois at Urbana-Champaign
 * http://cogcomp.cs.illinois.edu/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal with the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimers.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimers in the documentation and/or other materials provided with the distribution.
 * Neither the names of the Cognitive Computations Group, nor the University of Illinois at Urbana-Champaign, nor the names of its contributors may be used to endorse or promote products derived from this Software without specific prior written permission.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE SOFTWARE.
 *     
 *******************************************************************************/
package edu.illinois.cs.cogcomp.sl.util;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.Serializable;

/**
 * The class test DenseVector
 * 
 * @author Kai-Wei Chang
 * 
 */
public class UtilTest {

	@Test 
	public void testDenseVector(){
		int size = 10;
		DenseVector myVector1 = new DenseVector(size);		

		// Test set and get
		myVector1.setElement(3,5.0f);
        assertEquals(myVector1.get(3), 5.0f, 1e-8f);

		// Test squareL2Norm
        assertEquals(myVector1.getSquareL2Norm(), 25.0f, 1e-8f);

		// Test scale
		myVector1.scale(2);
        assertEquals(myVector1.get(3), 10.0f, 1e-8f);

		// Test addDenseVector
		DenseVector myVector2 = new DenseVector(size);
		myVector2.setElement(3,3.0f);
		myVector1.addDenseVector(myVector2);
        assertEquals(myVector1.get(3), 13.0f, 1e-8f);
		myVector2.setElement(5,3.0f);
		myVector1.addDenseVector(myVector2);
        assertEquals(myVector1.get(5), 3.0f, 1e-8f);
        assertEquals(myVector1.get(3), 16.0f, 1e-8f);

		// Test addSparseVector
	}

	@Test 
	public void testSparseVector(){
		int size = 10;
		int[] indices = new int[]{1, 2, 3};
		float[] values = new float[]{1.0f, 2.0f, 3.0f};
		SparseFeatureVector myVector1 = new SparseFeatureVector(indices, values);		

		// Test squareL2Norm
        assertEquals(myVector1.getSquareL2Norm(), 14.0f, 1e-8f);		
        assertEquals(myVector1.getNumActiveFeatures(), 3);

		// Test active features
		// Test scale
		myVector1.multiply(2);

		// check the third element in the vector
        assertEquals(myVector1.getValue(2), 6.0f, 1e-8f);
        assertEquals(myVector1.getSquareL2Norm(), 56.0f, 1e-8f);

		// Test difference
		IFeatureVector myVector2 = myVector1.difference(myVector1);
        assertEquals(myVector2.getSquareL2Norm(), 0.0f, 1e-8f);
	}
}
