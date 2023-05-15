package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 1);
        String name = box.whatsThis();
        assertThat(name).isNotEmpty()
                .doesNotContain("Cu")
                .contains("phe")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).isNotEmpty()
                .doesNotContain("Tet")
                .contains("ub")
                .isEqualTo("Cube");
    }

    @Test
    void getNumberOfVertices0() {
        Box box = new Box(0, 1);
        int rs = box.getNumberOfVertices();
        assertThat(rs).isNotNegative()
                .isNotPositive()
                .isEqualTo(0);
    }

    @Test
    void getNumberOfVertices4() {
        Box box = new Box(4, 6);
        int rs = box.getNumberOfVertices();
        assertThat(rs).isNotZero()
                .isPositive()
                .isEqualTo(4);
    }

    @Test
    void isExistTrue() {
        Box box = new Box(4, 6);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(5, 5);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void getAreaSphere() {
        Box box = new Box(0, 3);
        assertThat(box.getArea()).isEqualTo(113.1d, withPrecision(0.01d))
                .isGreaterThan(113.08)
                .isLessThan(113.2);
    }

    @Test
    void getAreaTet() {
        Box box = new Box(4, 6);
        assertThat(box.getArea()).isEqualTo(62.35, withPrecision(0.004d))
                .isGreaterThan(62.35)
                .isLessThan(62.354);
    }

}