/*
 * Copyright 2013 Filippo De Luca - me@filippodeluca.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.filosganga.geogson.model;

import static com.github.filosganga.geogson.model.Matchers.pointThatHave;
import static com.github.filosganga.geogson.model.Matchers.pointWithLonLat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

public class PointTest {

    @Test
    public void ofLonLatShouldReturnRightValues() {

        assertThat(Point.from(10, 20), is(pointWithLonLat(10, 20)));
    }

    @Test
    public void ofCoordinateShouldReturnRightValues() {

        Coordinates coordinates = Coordinates.of(-10, 60);

        assertThat(Point.from(coordinates), is(pointThatHave(is(coordinates))));
    }

    @Test
    public void withLonShouldReturnRightValues() {

        assertThat(Point.from(10, 20).withLon(15), is(pointWithLonLat(15, 20)));
    }

    @Test
    public void withLatShouldReturnRightValues() {

        assertThat(Point.from(10, 20).withLat(25), is(pointWithLonLat(10, 25)));
    }

    @Test
    public void equalsHashCodeShouldDependByCoordinate() {

        Point base = Point.from(10, 20);
        Point same = Point.from(10, 20);

        Point different = Point.from(10, 21);


        assertThat(base.equals(null), is(false));
        assertThat(base.equals(base), is(true));

        assertThat(ImmutableSet.of(base, same, different).size(), is(2));
    }

}
