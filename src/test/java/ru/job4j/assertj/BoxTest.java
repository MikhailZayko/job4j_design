package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 8);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isNotEmpty()
                .isNotNull()
                .contains("ub")
                .doesNotContain("Sphere")
                .startsWith("C");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(5, 3);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object")
                .startsWith("Unk")
                .doesNotStartWith("Obj")
                .contains("own")
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    void whenVertexIs4() {
        Box box = new Box(4, 1);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(4)
                .isGreaterThan(3)
                .isLessThan(6)
                .isEven()
                .isPositive()
                .isNotZero();
    }

    @Test
    void whenVertexIsMinus1() {
        Box box = new Box(5, 0);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(-1)
                .isNotZero()
                .isNotPositive()
                .isGreaterThan(-4)
                .isLessThan(0)
                .isNegative();
    }

    @Test
    void whenIsExist() {
        Box box = new Box(0, 1);
        boolean result = box.isExist();
        assertThat(result).isTrue()
                .isEqualTo(true)
                .isNotEqualTo(false);
    }

    @Test
    void whenIsNotExist() {
        Box box = new Box(11, -5);
        boolean result = box.isExist();
        assertThat(result).isFalse()
                .isEqualTo(false)
                .isNotEqualTo(true);
    }

    @Test
    void whenVertex0AndEdge2ThenArea50dot26() {
        Box box = new Box(0, 2);
        double result = box.getArea();
        assertThat(result).isCloseTo(50.26D, withPrecision(0.01D))
                .isGreaterThan(11.11D)
                .isLessThan(77.77D);
    }

    @Test
    void whenVertex5AndEdge0ThenArea0() {
        Box box = new Box(5, 0);
        double result = box.getArea();
        assertThat(result).isCloseTo(0D, withPrecision(0.1D))
                .isGreaterThan(-21.1D)
                .isLessThan(1.1D);
    }
}