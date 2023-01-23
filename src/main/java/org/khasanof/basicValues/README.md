# BasicValues

A basic type is a mapping between a Java type and a single database column.

Hibernate can map many standard Java types (Integer, String, etc.) as basic types. The mapping for many come from tables
B-3 and B-4 in the JDBC specification[jdbc]. Others (URL as VARCHAR, e.g.) simply make sense.

Additionally, Hibernate provides multiple, flexible ways to indicate how the Java type should be mapped to the database.

<table>
    <tr>
        <th width="30%">Category</th>
        <th width="30%">Package</th>
        <th>Types</th>
    </tr>
    <tr>
        <td>Java primitive types</td>
        <td> </td>
        <td>boolean, int, double, etc.</td>
    </tr>
    <tr>
        <td>Primitive wrappers</td>
        <td>java.lang</td>
        <td>Boolean, Integer, Double, etc.</td>
    </tr>
    <tr>
        <td>Strings</td>
        <td>java.lang</td>
        <td>String</td>
    </tr>
    <tr>
        <td>Arbitrary-precision numeric types</td>
        <td>java.math</td>
        <td>BigInteger and BigDecimal</td>
    </tr>
    <tr>
        <td>Date/time types</td>
        <td>java.time</td>
        <td>LocalDate, LocalTime, LocalDateTime, OffsetTime, OffsetDateTime, Instant</td>
    </tr>
    <tr>
        <td>Deprecated date/time types</td>
        <td>java.util</td>
        <td>Date and Calendar</td>
    </tr>
    <tr>
        <td>Deprecated date/time types from</td>
        <td>java.sql</td>
        <td>Date, Time, Timestamp</td>
    </tr>
    <tr>
        <td>Byte and character arrays</td>
        <td> </td>
        <td>byte[] or Byte[], char[] or Character[]</td>
    </tr>
    <tr>
        <td>Java enumerated types</td>
        <td> </td>
        <td>Any enum</td>
    </tr>
    <tr>
        <td>Serializable types</td>
        <td> </td>
        <td>Any type that implements java.io.Serializable</td>
    </tr>
</table>