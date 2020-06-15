Oracle JDBC Drivers release 11.2.0.1.0 production Readme.txt
==========================================================


What Is New In This Release ?
-----------------------------

Universal Connection Pool
    In this release the Oracle Implicit Connection Cache feature is
    deprecated. Users are strongly encouraged to use the new Universal
    Connection Pool instead. The UCP has all of the features of the
    ICC, plus much more. The UCP is available in a separate jar file,
    ucp.jar. 

Column Security
    When a table is XDS (eXtensible Data Security) enabled, some
    objects (or rows) may be invisible to the user depending on the
    security constraints. Moreover, an object (or row) can be visible
    but some of its attributes (or columns) may not be. Starting in
    11gR2, the JDBC drivers support these new security attributes and
    let you determine whether a particular column has some security
    attributes and whether a column value is null because it's hidden
    or because it's actually null. 

Secure Lob
    Additional support for the Oracle Database 11.1 Secure LOB feature.

Lob prefetch
    Improves the performance of some LOB read operations by fetching
    the initial bytes or chars of the LOB along with the locator. For
    very small LOBs, less than a few thousand bytes, the entire LOB
    value may be fetched. This improves the performance of reads on
    very small lobs and reads of the initial bytes or chars on all
    LOBS. 

Network Connection Pool
    The network connection pool allows multiple java.sql.Connection
    objects to share a limited number of network level channels. Each
    Connection is associated with a single database session. The
    Connection object communicates with the session over a network
    channel. When the network connection pool is enabled, network
    channels are shared among multiple Connection/session pairs. In
    some situations this can reduce the resources consumed on both the
    client and server and improve performance and scalability.

XMLType Queue Support in AQ
    Oracle Database 11gR1 JDBC introduced high performance access to
    Oracle Advanced Queueing. This release extends this support by
    providing high performance access to queues that use SQL XMLType.

Notification Grouping in AQ and DCN
    Notification Grouping is a new feature of JDBC Notification which
    was included in Database 11gR1 and which includes AQ Notification
    as well as Database Change Notification. You can now ask the
    database to group notifications for example every 60 seconds. When
    using Notification Grouping, you are given the option to either
    get only the last notification or a summary of them.

TimeZone Patching
    Improved support for time zones that are not directly supported by
    the client Java environment.

Reduced Memory Footprint
    In 10gR1 we rearchitected the drivers to improve performance at
    the cost of increasing memory footprint, especially when using the
    (highly recommended!) statement cache. We achieved our goal of
    improving performance, but the increase in memory footprint has
    sometimes proved problematic. The 11gR1 release retained the
    performance improvements and reduced the memory footprint for
    most users. The 11gR2 release provides some tuning options for
    that subset of users that need them. This is users with large
    numbers of connections and large statement caches. See the JavaDoc
    for oracle.jdbc.OracleConnection.CONNECTION_PROPERTY_USE_THREADLOCAL_BUFFER_CACHE 
    and CONNECTION_PROPERTY_MAX_CACHED_BUFFER_SIZE for details. Don't
    worry about this unless you are running out of heap.


Driver Versions
---------------

These are the driver versions in the 11R2 release:

  - JDBC Thin Driver 11R2
    100% Java client-side JDBC driver for use in client applications,
    middle-tier servers and applets.

  - JDBC OCI Driver 11R2
    Client-side JDBC driver for use on a machine where OCI 11R2
    is installed.

  - JDBC Thin Server-side Driver 11R2
    JDBC driver for use in Java program in the database to access
    remote Oracle databases.

  - JDBC Server-side Internal Driver 11R2
    Server-side JDBC driver for use by Java Stored procedures.  This
    driver used to be called the "JDBC Kprb Driver".

For complete documentation, please refer to "JDBC Developer's Guide
and Reference".


Contents Of This Release
------------------------

For all platforms:

  [ORACLE_HOME]/jdbc/lib contains:

  - ojdbc5.jar
    Classes for use with JDK 1.5.  It contains the JDBC driver
    classes, except classes for NLS support in Oracle Object and
    Collection types.

  - ojdbc5_g.jar
    Same as ojdbc5.jar, except that classes were compiled with
    "javac -g" and contain tracing code.

  - ojdbc5dms.jar
    Same as ojdbc5.jar, except that it contains instrumentation to
    support DMS and limited java.util.logging calls.

  - ojdbc5dms_g.jar
    Same as ojdbc5_g.jar, except that it contains instrumentation to
    support DMS.

  - ojdbc6.jar
    Classes for use with JDK 1.6. It contains the JDBC driver classes
    except classes for NLS support in Oracle Object and Collection
    types. 

  - ojdbc6_g.jar
    Same as ojdbc6.jar except compiled with "javac -g" and contains
    tracing code.

  - ojdbc6dms.jar
    Same as ojdbc6.jar, except that it contains instrumentation to
    support DMS and limited java.util.logging calls.

  - ojdbc6dms_g.jar
    Same as ojdbc6_g.jar except that it contains instrumentation to
    support DMS.

  Note: The dms versions of the jar files are the same as 
    standard jar files, except that they contain additional code
    to support Oracle Dynamic Monitoring Service. They contain a
    limited amount of tracing code. These can only be used
    when dms.jar is in the classpath. dms.jar is provided as part of
    Oracle Application Server releases. As a result the dms versions
    of the jar files can only be used in an Oracle Application Server
    environment. 

  [ORACLE_HOME]/jdbc/doc/javadoc.tar contains the JDBC Javadoc
  for the public API of the public classes of Oracle JDBC. This
  JavaDoc is the primary reference for Oracle JDBC API extensions. The
  Oracle JDBC Development Guide contains high level discussion of
  Oracle extensions. The details are in this JavaDoc. The JavaDoc is
  every bit as authorative as the Dev Guide.

  [ORACLE_HOME]/jdbc/demo/demo.tar contains sample JDBC programs.

  [ORACLE_HOME]/jlib/orai18n.jar
    NLS classes for use with JDK 1.5, and 1.6.  It contains
    classes for NLS support in Oracle Object and Collection types.
    This jar file replaces the old nls_charset jar/zip files. In 
    Oracle 10g R1 it was duplicated in [ORACLE_HOME]/jdbc/lib. We
    have removed the duplicate copy and you should now get it from
    its proper location.


For the Windows platform:

  [ORACLE_HOME]\bin directory contains ocijdbc11.dll and
  heteroxa11.dll, which are the libraries used by the JDBC OCI
  driver.

For non-Windows platforms:

  [ORACLE_HOME]/lib directory contains libocijdbc11.so,
  libocijdbc11_g.so, libheteroxa11.so and libheteroxa11_g.so, which
  are the shared libraries used by the JDBC OCI driver.


NLS Extension Jar File (for client-side only)
---------------------------------------------

The JDBC Server-side Internal Driver provides complete NLS support.
It does not require any NLS extension jar file.  Discussions in this
section only apply to the Oracle JDBC Thin and JDBC OCI drivers.

The basic jar files (ojdbc5.jar and ojdbc6.jar) contain all the
necessary classes to provide complete NLS support for:

  - Oracle Character sets for CHAR/VARCHAR/LONGVARCHAR/CLOB type data
    that is not retrieved or inserted as a data member of an Oracle
    Object or Collection type.

  - NLS support for CHAR/VARCHAR data members of Objects and
    Collections for a few commonly used character sets.  These
    character sets are:  US7ASCII, WE8DEC, WE8ISO8859P1, WE8MSWIN1252,
    and UTF8.

Users must include the NLS extension jar file
([ORACLE_HOME]/jlib/orai18n.jar) in their CLASSPATH if utilization of
other character sets in CHAR/VARCHAR data members of
Objects/Collections is desired.  The new orai18n.jar replaces the
nls_charset*.* files in the 9i and older releases.

The file orai18n.jar contains many important character-related files.
Most of these files are essential to globalization support.  Instead
of extracting only the character-set files your application uses, it
is safest to follow this three-step process: 1.  Unpack orai18n.jar
into a temporary directory.  2.  Delete the character-set files that
your application does not use.  Do not delete any territory, collation
sequence, or mapping files.  3.  Create a new orai18n.jar file from
the temporary directory and add the altered file to your CLASSPATH.
See the JDBC Developers Guide for more information.

In addition, users can also include internationalized Jdbc error
message files selectively.  The message files are included in the
oracle/jdbc/driver/Messages_*.properties files in ojdbc5*.jar and
ojdbc6*.jar. 


-----------------------------------------------------------------------


Installation
------------

Please do not try to put multiple versions of the Oracle JDBC drivers
in your CLASSPATH.  The Oracle installer installs the JDBC Drivers in
the [ORACLE_HOME]/jdbc directory.


Setting Up Your Environment
---------------------------

On Windows platforms:
  - Add [ORACLE_HOME]\jdbc\lib\ojdbc5.jar to
    your CLASSPATH if you use JDK 1.5 or
    [ORACLE_HOME]\jdbc\lib\ojdbc6.jar if you use JDK 1.6.
  - Add [ORACLE_HOME]\jlib\orai18n.jar to your CLASSPATH if needed.
  - Add [ORACLE_HOME]\bin to your PATH if you are using the JDBC OCI
    driver.

On Solaris/Digital Unix:
  - Add [ORACLE_HOME]/jdbc/lib/ojdbc5.jar to your CLASSPATH if you
    use JDK 1.5 or [ORACLE_HOME]/jdbc/lib/ojdbc6.jar if you use JDK 1.6
  - Add [ORACLE_HOME]/jlib/orai18n.jar to your CLASSPATH if needed.
  - Add [ORACLE_HOME]/jdbc/lib to your LD_LIBRARY_PATH if you use
    the JDBC OCI driver.

On HP/UX:
  - Add [ORACLE_HOME]/jdbc/lib/ojdbc5.jar to your CLASSPATH if you
    use JDK 1.5 or [ORACLE_HOME]/jdbc/lib/ojdbc6.jar if you use JDK 1.6
  - Add [ORACLE_HOME]/jlib/orai18n.jar to your CLASSPATH if needed.
  - Add [ORACLE_HOME]/jdbc/lib to your SHLIB_PATH and LD_LIBRARY_PATH
    if you use the JDBC OCI driver.

On AIX:
  - Add [ORACLE_HOME]/jdbc/lib/ojdbc5.jar to your CLASSPATH if you
    use JDK 1.5 or [ORACLE_HOME]/jdbc/lib/ojdbc6.jar if you use JDK 1.6
  - Add [ORACLE_HOME]/jlib/orai18n.jar to your CLASSPATH if needed.
  - Add [ORACLE_HOME]/jdbc/lib to your LIBPATH and LD_LIBRARY_PATH
    if you use the JDBC OCI driver.


Some Useful Hints In Using the JDBC Drivers
-------------------------------------------

Please refer to "JDBC Developer's Guide and Reference" for details
regarding usage of Oracle's JDBC Drivers.  This section only offers
useful hints.  These hints are not meant to be exhaustive.

These are a few simple things that you should do in your JDBC program:

 1. Import the necessary JDBC classes in your programs that use JDBC.
    For example:

      import java.sql.*;
      import java.math.*; // if needed

    To use OracleDataSource, you need to do:
      import oracle.jdbc.pool.OracleDataSource;

 2. Create an OracleDataSource instance. 

      OracleDataSource ods = new OracleDataSource();

 3. set the desired properties if you don't want to use the
    default properties. Different connection URLs should be
    used for different JDBC drivers.

      ods.setUser("my_user");
      ods.setPassword("my_password");

    For the JDBC OCI Driver:
      To make a bequeath connection, set URL as:
      ods.setURL("jdbc:oracle:oci:@");

      To make a remote connection, set URL as:
      ods.setURL("jdbc:oracle:oci:@<database>");

      where <database> is either a TNSEntryName 
      or a SQL*net name-value pair defined in tnsnames.ora.
 
    For the JDBC Thin Driver, or Server-side Thin Driver:
      ods.setURL("jdbc:oracle:thin:@<database>");

      where <database> is either a string of the form
      //<host>:<port>/<service_name>, or a SQL*net name-value pair,
      or a TNSEntryName.

    For the JDBC Server-side Internal Driver:
      ods.setURL("jdbc:oracle:kprb:");

      Note that the trailing ':' is necessary. When you use the 
      Server-side Internal Driver, you always connect to the
      database you are executing in. You can also do this:

      Connection conn =
        new oracle.jdbc.OracleDriver().defaultConnection();

 4. Open a connection to the database with getConnection()
    methods defined in OracleDataSource class.

      Connection conn = ods.getConnection();


-----------------------------------------------------------------------


Java Stored Procedures
----------------------

Examples for callins and instance methods using Oracle Object Types
can be found in:

  [ORACLE_HOME]/javavm/demo/demo.zip

After you unzip the file, you will find the examples under:

  [ORACLE_HOME]/javavm/demo/examples/jsp


Known Problems/Limitations Fixed in This Release
------------------------------------------------


BUG-8343138
    java.lang.ArrayEndexOutOfBoundsException: 2048 during owb repo
    installation

BUG-8304386
    Scrollable ResultSet does not have error handling and throws
    NullPointerException 

BUG-8252445
    TIMESTAMP inserted into TIMESTAMPTZ could be wrong in the Thin
    driver.

BUG-8225653
    Irish/Ireland (ga_IE) not suported in JDBC.

BUG-8215177
    Performance issue in 11.1.0.7 with TIMESTAMPTZ.

BUG-8206371
    SQLException: java.io.NotSerializableException:
    oracle.net.ns.message11

BUG-7836895
    11.1.0.7 JDBC returning garbled characters

BUG-7706602
    Wrong type # returned for an XMLTYPE column.

BUG-7704823
    pe: eoostmt.c faile to compile in javavm_main_hpux.ia64_081230

BUG-7651637
    Method isBeforeFirst() working incorrectly after upgrade to 10.x
    and 11.x

BUG-7627150
    Access to SecureFile lobs will break with JDBC Thin if SSL or
    encryption/checksumming is turned on.

BUG-7585931
    TIMESTAMPTZ constructor could overwrite provided parameter.

BUG-7581389
    Protocol violation error when using getGeneratedKeys and
    CURSOR_SHARING=SIMILAR

BUG-7578881
    Autocommit set to false after global transaction is ended

BUG-7576651
    The following exception "java.sql.SQLException: Kernel column
    order not supported" occurs while selecting data from a database.

BUG-7554059
    getRow() doesn't return the correct rowcount.

BUG-7553583
    Before this fix, if a temporary lob is obtained from an out
    paramter of a CallableStatement wherethere is no in parameter set
    for the same index, a second execution of the statment causes the
    first temp lob to be freed.

BUG-7528681
    Error when SQL contains q' literals using { and } as the
    delimiters.

BUG-7503269
    ORA-1460 calling setPLSQLIndexTable with parameter elemMaxLen set
    to zero

BUG-7481206
    Unsupported timezones in the database could lead to JDBC leaving
    open, orphaned cursors.

BUG-7460022
    ClassCastException from ARRAY.toARRAY when CustomDatum is passed

BUG-7449648
    internal error using oracle.sql.ArrayDescriptor.getbasename with
    synonym

BUG-7431931
    Added JDBC support for Norwegian BokmC%l

BUG-7427651
    Conversion of BC date via oracle.sql.date would lose a year.

BUG-7424490
    ArrayOutOfBoundsException while reading TIMESTAMP type.

BUG-7422965
    Insert via a synonym would fail.

BUG-7418148
    Issue of empty and null stream for PreaparedLtatment.setXXXStream

BUG-7413658
    Corrects OCI-21500 errors which might occur when freeTemporary is
    called on a BLOB or CLOB instance which was obtained from and
    STRUCT or ARRAY.

BUG-7407996
    Whenever an XA operation is attempted on a closed JDBC connection,
    the XA exception sent is of type RMERR instead of RMFAIL.

BUG-7382521
    Refreshing the pooled connection cache to remove invalid
    connections could close and reopen perfectly valid physical
    connections.

BUG-7381439
    spin while trying to close a resultset

BUG-7365373
    wasNull() not working for ADTs

BUG-7365036
    oracle.sql.TIMESTAMPTZ.toTime returns the wrong value. This is
    most visible when calling getTime on a scrollable result set.

BUG-7360273
    Performance improvement in XA

BUG-7356957
    Re-work setCharacterStream()

BUG-7346587
    Methods for bulk loading of TypeDescriptors such as
    getTypeDescriptorsFromList create badly formed descriptors for
    ARRAY types with primitive element types. Creation of ARRAY
    objects fail with NullPointerExceptions in setConnection method.

BUG-7340408
    getTime() on a TIMESTAMPLTZ column could return the wrong value.

BUG-7331329
    When using ojdbc6.jar with JDK6, ResultSetMetaData for columns of
    NCHAR, NVARCHAR, or NCLOB are now identified with the new JDBC 4.0
    N* types

BUG-7304027
    Consistent behavior of getBoolean.

BUG-7288889
    Driver does not store the correct internal data buffer sizes. This
    can be a problem in low memory conditions as the driver can
    attempt to use buffers that are larger than would otherwise be
    necessary. Is not a problem except when in very low memory
    conditions. Fix also add a new connection property
    oracle.jdbc.maxCachedBufferSize which limits the size of the data
    buffers that are cached for reuse. It is better to manage the data
    buffer size by setting fetch size appropriately for each
    statement, but if that is not feasible, setting
    maxCachedBufferSize can reduce memory footprint at the expense of
    reduced performance for statements that require buffers larger
    than the max.

BUG-7284982
    XAResource might not free up space correctly from internal list.

BUG-7280437
    delete obsolete Catlan message file

BUG-7271988
    Error in behavior of PreparedStatement.setBytes in batching
    corrected.

BUG-7271519
    Out of range Oracle date datatypes could be inserted into the
    database.

BUG-7249052
    It was possible to construct invalid Oracle DATE values.

BUG-7248917
    Completes implementation of new JDBC4.0 methods in
    UpdatableResultSet

BUG-7243157
    Raise an appropriate error when attempting to use a date with year
    exceeding 9999.

BUG-7236518
    An INSERT with returned generated keys would fail when the target
    object was a view and an OCI connection was use.

BUG-7230912
    Adding ojdbc5.jar or ojdbc6.jar to the bootclasspath results in a
    NullPointerException.

BUG-7206547
    Certain errors generate a default SQLSTATE code of 99999 instead a
    more specific code.

BUG-7204773
    SetObject with types.Numeric on string throws
    NumberFormatException

BUG-7193728
    XA exceptions are obscure. The user can't retrieve the error
     message from the database.

BUG-7190386
    ANYDATA.stringValue() throws NullPointerException when it is
    created standalone.

BUG-7189306
    Preformance degration while inserting Timestamp type

BUG-7171343
    Selected UROWID not printable from ROWID.stringValue().

BUG-7167966
    The setXXXStream position argument would accept 0 as a position.
    This is contrary to the JDBC spec which states that 1 is the first
    position. The JDBC spec requires that these methods raise an
    exception if the position is 0. See the JavaDoc for the connection
    property that restores the old, incorrect behavior.

BUG-7157850
    Blob.position(Blob, long) does not work when Blob is retrieved
    from Rowset

BUG-7157670
    JDBC 4.0 methods in OracleSerialClob &amp; OracleSerialBlob not
    working properly

BUG-7154611
    Wrong timestamps when the default locale is set to Thai or
    similar.

BUG-7154221
    ArrayOutOfBoundsException while fetching a type of OPAQUE

BUG-7149854
     Wrong data inserted when using a batch.

BUG-7145669
    With a result set of TYPE_SCROLL_INSENSITIVE, calling get bytes on
    a blob col umn gets invalid column type error.

BUG-7139205 
    after OracleCachedRowset.setTimestamp(int,timestamp,calendar),
    execute() fails

BUG-7138794
    after OracleCachedRowset.setBytes is called, execute() gets
    ClassCastException

BUG-7125637
    JDBC driver does not support OCI_ATTR_DRIVER_NAME.

BUG-7120672
    Not able to connect from 11.2 to 11.1 or earlier versions

BUG-7120523
    OracleCachedRowset.updateXXXStream/updateClob/updateBlob do not
    work

BUG-7119903
    OracleCachedRowset.getNClob does not work

BUG-7115140
    Clob.getCharacterStream(long pos, long length) does not work

BUG-7115040
    clob.getSubstring does not work well on clob returned by
    OracleCachedRowSet

BUG-7112447
    Executing a statement with 8 or more paramters returning
    auto-generated keys throws ArrayIndexOutOfBounds. Do not use named
    parameters with simple integer parameter names, e.g. :1, :2,
    :3. This limitation will be addressed in a future release.

BUG-7110777
    setBinaryStream throws JAVA.SQL.SQLRECOVERABLEEXCEPTION: IO
    EXCEPTION afte r applying patch 6669350

BUG-7110696
    JDBC 11.1.0.6 App hangs when using setAsciiStream

BUG-7030404
    Timeout of JDBC implicit conneciton cache causes deadlock

BUG-7030220
    The method getFunctionParameters in JDBC4.0 was renamed to
    getFunctionColumns in the final spec. The obsolete method
    implementation was inadvertantly left in
    oracle.jdbc.OracleDatabaseMetaData. This fix removes it.

BUG-7030194
    Missing updateAscii/Binary/NCharacterStream methods without length
    parameter in updatable ResultSet.

BUG-7028633
    TIMESTAMPLTZ problems with resultsets.

BUG-7028625
    DST problems with TIMEZONETZ around DST switchover.

BUG-7019862
    Using defineColumnType to define a CHAR or VARCHAR column as
    BINARY, VARBINAR Y, or LONGVARBINARY results in the incorrect
    interpretation of the value when us ing the Thin driver.

BUG-7017170
    Jdbc-oci goes into a spin while reading stream

BUG-7009957
    Applies to dev branch onlue.

BUG-7009875
    Improve handling of error when year exceeds 9999.

BUG-7009796
    Calling getString or getNString on a BLOB column may return null
     although the data isn't null.

BUG-7009536
    getNClob throws an exception for a scrollable result set.

BUG-7004166
    getTIMESTAMP throws an exception when column is a DATE in
    scrollable resulset .

BUG-6998442
    OCI-21710 error with JDBC OCI and proxy authentication

BUG-6997621
    Methods such as getTime or getInt wouldn't work on CHAR data in
    scrollable re sultset.

BUG-6994043
    Calling getURL on a null character value on a scrollable or
    updateable result set throws an exception rather than returning
    null.

BUG-6991804
    Calling getBytes() from a scrollable resultset throws an
    exception.

BUG-6991207
    .floatValue, .doubleValue &amp; .bigDecimalValue in BINARY_FLOAT
    .doubleValue, .bigDecimalValue in BINARY_DOUBLE

BUG-6989806
    Multi-threaded program using Jdbc-OCI driver using LOB feature
    could end up in unexpected errors without this fix.

BUG-6988302
    ORA-01460 while executing a query with defineColumnType

BUG-6987800
    Calling getURL on an updateable result set causes an exception.

BUG-6977990
    Wrong value TIMESTAMPLTZ when the retrieved timestamp is in the
    DST overlap for the session timezone.

BUG-6924460
    OracleXADataSource does not support user/password to be specified
    in URL

BUG-6919246
    Calling getCursor and closing the returned ResultSet but not
    closing the parent statement results in a memory leak.

BUG-6907759
    Jdbc Thin driver doesn't populate the program name in the
    listener.

BUG-6902740
    Buffer sizes for InputStreams and Readers will adapt to the size of
    user read calls for sizes over about 32k  

BUG-6899821
    data corruption for setBytes and setBinaryStream in kprb driver
    for blob columns

BUG-6892983
    Updateable Resultset(RESULTSET.CONCUR_UPDATABLE) causes bad use of
    bind va rs

BUG-6889743
    Scrollable ResultSet returns truncated char data

BUG-6887548
    Execute plsql functions through jdbc, return zero without error
    message

BUG-6883730
    Potential memory access error in native code in low memory
    situation.

BUG-6882024
    A PreparedStatement with no bind values used with addBatch only
    inserts one r ow.

BUG-6880991
    Use SSL for encryption and RADIUS for authentication isn't
    possible because o f this bug.

BUG-6870832
    TIMESTAMPLTZ out by one hour near DST changeover.

BUG-6857474
    Cannot close sniped connection, Oracle processes are not cleaned
    up

BUG-6855076
    When using Oracle JDBC XA connections, the JDBC driver incorrectly
    returns XAER_RMERR when the connection is killed using the command
    'ALTER SYSTEM KILL SESSION'.  The expected correct
    result should be XAER_RMFAIL.

BUG-6845838
    Wrong data returned when type declared as Anydata

BUG-6838596
    When a statement returns a cursor, canceling the statement does
    not cancel execution of a query that is retrieving the value of
    the cursor.

BUG-6826205
    A DMS Noun is used after the Noun has been destroyed.

BUG-6806207
    Select :bnd fails if bnd is bound null first

BUG-6799742
    The fields in the MANIFEST.MF file were not in the recommended
    format.

BUG-6764986
    Four JDBC internal calls to methods with public APIs appear in the
    trace log even when configured for public calls only.

BUG-6761190
    Statement.Cancel() does not work with
    PreparedStatement.executeBatch()

BUG-6758976
    Wrong results could be obtained when a query involving a view or
    synonym was issued via JDBC.

BUG-6753667
    XMLType queues are not supported in the JDBC thin driver.

BUG-6750400
    Statement DMS Noun name is the SQL string.

BUG-6749708
    JDBC Thin connections do not convert non-ASCII characters

BUG-6749302
    Timestamps incorrect around DST changeover time.

BUG-6730535
    JDBC would raise an error as a result of falsely identifying DML
    as containing a RETURNING clause.

BUG-6679278
    Wrong values inserted when using INTERVALDS.

BUG-6670871
    The thin driver doesn't return the right database version.

BUG-6669350
    Setting connection cache attributes must be in certain order

BUG-6668623
    JDBC driver consumes large amounts of memory. Application uses
    Oracle JDBC implicit statement cache, has many open connections,
    and only a very few connections are in use at any one time. All
    other connections are unused and all statements in those
    connections are closed.

BUG-6661592
    DatabaseMetaData.getColumns returned the schema the target table
    rather then the schema of a synonym.

BUG-6658080
    The connection property "oracle.net.wallet_location" isn't
    properly handled.

BUG-6655200
    When using PKCS12 wallets, Oracle's PKI provider needs to be
    used. If it's en abled statically through java.security, it also
    needs to be instantiated in t he Java code otherwise it won't be
    used. This is a bug, it should be instanti ated by the driver not
    the user code.

BUG-6654960
    The AQ notification event doesn't handle character strings
    correctly if orai1 8n.jar isn't in the classpath.

BUG-6638862
    Setting connection cache attributes must be in certain order

BUG-6632928
    This fix makes OracleConnection.getEncryptionAlgorithmName return
    the cipher used when the connection is using SSL.

BUG-6632613
    TLS_RSA_WITH_AES_128_CBC_SHA and TLS_RSA_WITH_AES_256_CBC_SHA
     ciphers can now be used with the JDCB thin driver.

BUG-6629144
    Exception when input string contains unicode replacement character

BUG-6611596
    end(SUCCESS) when a transaction is in suspend mode was not working
    properly it is fixed by this fix.

BUG-6611225
    Memory leak because of T4C8TTIuds

BUG-6601831
    JDBC OCI driver errors with ORA-01459 during standard batching
    call

BUG-6599470
    Call to UpdateCharacterStream fails with
    java.lang.OutOfMemoryError

BUG-6598195
    Missing nanoseconds on a timestamp returned by getTIMESTAMP, get
    TIMESTAMPLTZ etc.

BUG-6531778
    Some SQL92 escape function were not implemented. This fix adds all
    functions that it is feasible to implement.

BUG-6525017
    Appears as an exception when serializing an instance of an
    oracle.sql.Datum subclass.

BUG-6522973
    NullPointerException while using OCI driver from checkError

BUG-6522392
    Column size returned for NCHAR/NVARCHAR2 is doubled when using
    DatabaseMetaData.getColumns()

BUG-6496226
    Use of the stream obtained from java.sql.Blob.setBinaryStream and
    CLob.setCha racterStream and setAsciiStream is slow when the
    buffers written to the strea m are megabyts in size.

BUG-6491743
    Exception while using savepoints with a pooled connection

BUG-6474141
    large memory used for null columns

BUG-6459503
    The FUNCTION_TYPE column is not present in the ResultSet returned
    by DatabaseMetadata.getFunctions.

BUG-6454501
    Support language KAZAKH

BUG-6453298
    SQLException is thrown when user.language is set to "sr"

BUG-6445341
    DMS version of JDBC method Namespace.setAttribute throws a
    NullPointerException when communicating with the database. 

BUG-6443045
    ORA-00600 when a Struct with null attributes bound

BUG-6441084
    ResultSetMetaData.GetColumnTypeName for TIMESTAMPTZ and
    TIMESTAMPLTZ is no t descriptive

BUG-6431772
    JDBC 4.0: multiple frees on a Blob/Clob causes SQLException.

BUG-6407808
    The driver no longer raise events on PooledConnections.

BUG-6406402
    setTypeMap alters its argument, adding two additional entries.
    This fix alters the driver behavior so that it copies the argument
    rather than capturing it. Some code may no longer work. The new
    behavior is fully conformant with the JDBC specification and the
    user code will have to be changed. This will happen when the user
    code calls setTypeMap and the alters the map, expecting that the
    driver will see the change or when the user code calls getTypeMap
    and then alters the map.

BUG-6396398
    getClientInfo throws a SQLException rather than returning null.

BUG-6396242
    ArrayOutOfBoundsException while using Jdbc with a big batch.

BUG-6394952
    Jdbc does not let user close the connection when the connection
    hits ORA-3113

BUG-6373844
    Unsupported features in JDBC 4.0 do not throw
    SQLFeatureNotSupportedException

BUG-6365731
    JDBC doesn't set user password correctly if it consists a question
    mark (?) 

BUG-6362104
    JDBC driver throws MalformedObjectException or
    InstanceAlreadyExistsException when loading.

BUG-6342068
    The user input is passed to the server without checking its
    validity.

BUG-6338825
    Unable to catch oracle.ons.SubscriptionException when ONS is down

BUG-6312064
    Binding a Time value to the database in an insert used to set the
    Date component as 01-Jan-1900 in 9i since, the method
    java.sql.Time().getTime() does not trim the date component.
    However, during re-architecture of Jdbc in 10g this behavior was
    changed and the date component was not reset.   This
    caused a regression for 9i customers .  Resetting the value to
    01-Jan-1900 by default would cause a regression for the 10g users
    who have been using the flag for over 4 years until now.  So a new
    connection flag oracle.jdbc.use1900AsYearForTime was introduced
    which would force the driver to set the date component in the Time
    to 01-Jan-1900.   The default value of this flag is
    false.

BUG-6281527
    Null inserted through CachedRowset cannot be deleted without
    re-select

BUG-6279736
    Cancel does not work while connecting to 9.2 database when thin
    driver is used.

BUG-6275369
    Jdbc thin does not close the socket on a IOException

BUG-6267844
    ResultSet getAsciiStream returns incorrect characters for UTF8
    database

BUG-6241715
    NullPointerException while trying to obtain a connection from
    connection cache

BUG-6238601
    OracleDataSource.setLoginTimeout does not affect
    ImplicitConnectionCache

BUG-6216279
    Bad timestamp value insertion.

BUG-6208793
    Behavioural difference in isBeforeFirst between thin and oci when
    fetched as cursors

BUG-6203316
    NullPointerException in oracle.jdbc.driver.DatabaseError.throwSQLException.

BUG-6200206
    Convertion from AL16UTF16 to UTF16 is surrogate character
    sensitive.

BUG-6145041
    When an array which is not String[] nor char[] is bound using
    setPlsqlIndexTa ble with the type as
    VARCHAR.  SQLException(Internal error) is thrown instead
    of proper error.

BUG-6132499
    JDBC incorrectly classifies we8dec,we8iso8859p1,we8mswin1252 for
    conversion

BUG-6109228
    setQueryTimeout doesn't work with PreparedStatement.executeBatch

BUG-6084197
    Char data gets truncated to 2k by Jdbc client, even when the
    server sends > 2k

BUG-6068533
    Error code 0 masking real error code when getting connection.

BUG-6068467
    isTemprary() would return TRUE on an freed LOB locator.

BUG-6027586
    Application servers are unable to load multiple versions of the
    JDBC drivers and multiple versions of dependent jars such as
    xdb.jar.

BUG-6018198
    Calling CLOB.setString(long, String) to update a CLOB stored as
    SecureFile hangs in the OCI driver.

BUG-5976201
    NullPointerException while using Statement which is updatable

BUG-5940568
    A SQL string like "{ call spLengthTest(?, ?) }"  shows improper
    truncation of a varchar OUT argument with length beyond 4000 when
    the escaped form is used, but correct behavior when the Oracle
    specific PL/SQL block like "begin spLengthTest(?, ?); end;" is
    used.

BUG-5904762
    Excessive network usage and this rdbms resources during commit.

BUG-5701494
    If a result set contains a TIMESTAMPLTZ column followed by a LONG
    column, reading the LONG column gets an error.

BUG-5609480
    getUpdateCount returns wrong values with batching

BUG-5502145
    OracleStatement which is scrollable &amp; updatable acts weirdly
    when mulitple statements are executed.

BUG-5154482
    Unable to connect to the Oracle database using special german
    character s (+00DF)

BUG-4689310
    Proxy authentication fails with thin driver when the password is
    specified seperately

BUG-4464146
    JDBC drivers do not check "jdbc" for JDBC url from user

BUG-4408817
    DatabaseMetaData.getSearchStringEscape returns the wrong value.

BUG-4390875
    THIN driver throw NullPointerException for
    OracleResultSet.getString() of invalid characters in AL32UTF8
    database.

BUG-4325229
    KPRB driver insert 32766 or more characters using
    OraclePreparedStatement.setString() into a database LONG column.
    Data truncation occur when database character set is ZHT32TRIS.

BUG-4322830
    getTimestamp of  a TIMESTAMP WITH TIME ZONE value yields the wrong
    result. The returned Timestamp will print the same year, month,
    day, hour, minute, second, but most likely represents the wrong
    millisecond value. Timestamps are in the UTC time zone so if the
    TIMESTAMP WITH TIME ZONE value is in some other time zone, the
    Timestamp value will print the same values but will actually
    represent a different instant in time.

BUG-4183785
    Some oracle/net classes are duplicated in driver jars and NET jars
    like netcf g.jar

BUG-3303679
    Bogus and misleading message on failed connection.

BUG-2696213
    Synonyms for package or procedure names are now followed in
    DatabaseMetaData getProcedureColumns if the names do not include
    wildcards. See the javadoc for details.

BUG-2475998
    Query used for DatabaseMetaData.getColumns is very slow when
    setIncludeSynonyms is true.

BUG-2304318
    Need to know if next() failed due to max_rows

BUG-556502
    scale parameter doesn't work as expected


Known Problems/Limitations In This Release
------------------------------------------

The following is a list of known problems/limitations:

 *  Calling getSTRUCT() on ADT data in a ScrollableResultSet may
    result in a NullpointerException.

 *  Programs can fail to open 16 or more connections using our
    client-side drivers at any one time.  This is not a limitation 
    caused by the JDBC drivers.  It is most likely that the limit of
    per-process file descriptors is exceeded.  The solution is to 
    increase the limit. 

 *  The Server-side Internal Driver has the following limitation:
    - LONG and LONG RAW types are limited 32512 bytes for parameters
      of PL/SQL procedures. BUG-5965340
    - In a chain of SQLExceptions, only the first one in the chain
      will have a getSQLState value.
    - Batch updates with Oracle 8 Object, REF and Collection data
      types are not supported.

 *  The JDBC OCI driver on an SSL connection hangs when the Java
    Virtual Machine is running in green threads mode.  A work-around
    is to run the Java Virtual Machine in native threads mode.

 *  Date-time format, currency symbol and decimal symbols are always
    presented in American convention.

 *  The utility dbms_java.set_output or dbms_java.set_stream that is
    used for redirecting the System.out.println() in JSPs to stdout
    SHOULD NOT be used when JDBC tracing is turned on.  This is
    because the current implementation of dbms_java.set_output and
    set_stream uses JDBC to write the output to stdout.  The result
    would be an infinite loop.

 *  The JDBC OCI and Thin drivers do not read CHAR data via binary
    streams correctly.  In other word, using getBinaryStream() to
    retrieve CHAR data may yield incorrect results.  A work-around is
    to use either getCHAR() or getAsciiStream() instead.  The other
    alternative is to use getUnicodeStream() although the method is
    deprecated.

 *   There is a limitation for Triggers implemented in Java and Object
     Types. Triggers implemented as Java methods cannot have OUT
     arguments of Oracle 8 Object or Collection type.  This means the
     Java methods used to implement triggers cannot have arguments
     of the following types:

    - java.sql.Struct
    - java.sql.Array
    - oracle.sql.STRUCT
    - oracle.sql.ARRAY
    - oracle.jdbc2.Struct
    - oracle.jdbc2.Array
    - any class implementing oracle.jdbc2.SQLData or
      oracle.sql.CustomDatum

 *  The scrollable result set implementation has the following
    limitation:

    - setFetchDirection() on ScrollableResultSet does not do anything.
    - refreshRow() on ScrollableResultSet does not support all
      combinations of sensitivity and concurrency.  The following
      table depicts the supported combinations.

        Support     Type                       Concurrency
        -------------------------------------------------------
        no          TYPE_FORWARD_ONLY          CONCUR_READ_ONLY
        no          TYPE_FORWARD_ONLY          CONCUR_UPDATABLE
        no          TYPE_SCROLL_INSENSITIVE    CONCUR_READ_ONLY
        yes         TYPE_SCROLL_INSENSITIVE    CONCUR_UPDATABLE
        yes         TYPE_SCROLL_SENSITIVE      CONCUR_READ_ONLY
        yes         TYPE_SCROLL_SENSITIVE      CONCUR_UPDATABLE

 *  Limitation on using PreparedStatements to create triggers. Since
    :foo is recognized by the drivers as a SQL parameter, it is not
    possible to use :in and :out in SQL that defines a trigger when
    using a PreparedStatement. The workaround is to use a Statement
    instead. 

BUG-8295873
    Dequeue failed with SQLException when corrid and dequeue condition
    combined

BUG-8236689
    Excessive cpu consumption by Java stored proc when updating row

BUG-8206596
    Wrong TIMESTAMPTZ inserted by setTimestamp

BUG-7833945
    Intermittently mgw reports ora-21500 while in
    t2cconnection.freetemporary

BUG-7829722
    JDBC Thin intermittently inserts corrupt number values in
    unsupported configuration

BUG-7653491
    stress soa - aq jms topic enqueue sql consuming significant
    database time

BUG-7529748
    OCI performance problem

BUG-7431899
    the servererror trigger is not fired when insert null using
    OracleXAConnection

BUG-7357124
    ResultSet.getRowId fails to read VARCHAR2 with scrollable
    result set

BUG-7357118
    ResultSet.getRAW fails to read VARCHAR2 with scrollable
    result set

BUG-7357103
    ResultSet.getTIMESTAMPTZ fails to read data from scrollable
    result set

BUG-7354593
    ResultSet.getDate fails to read date stored in VARCHAR2

BUG-7351254
    ResultSet.getNumber fails to read number stored in VARCHAR2

BUG-7331353
    ResultSet.getAsciiStream has problem when read from NVARCHAR2 or
    NCHAR

BUG-7165350
    getOraclePlsqlIndexTable()/stringValue() causes a
    NullPointerException

BUG-7010112
    getXXXStream/getBytes/getString fail to read BFILE

BUG-6902846
    JDBC KPRB driver does not raise error for violation to deferred
    constraint

BUG-6748410
    JDBC 10.2.0.3 is slow when CallableStatement has many out
    parameters

BUG-6668732
    ORA-22922: nonexistent lob value - JDBC driver verion 11. There
    are a number of closely related bugs. All have to do with moving
    temporary LOBs around without really doing anything with them. If
    you actually modify the LOB the error won't occur.

BUG-6658636
    Exception when inserting into a remote table via insertRow method

BUG-6470838
    Need to fix compatibility issues with locale selection for db
    sessions.

BUG-6193695
    Question marks returned after select failover wiith utf8 d/b &
    national charsets

BUG-6127810
    java.sql.SQLException: ora-22922: nonexistent lob value

BUG-5976230
    executeBatch on statement fails to close updatable ResultSet

BUG-5478959
    addBatch missing lines using Java PreparedStatement class for
    stored proc

BUG-5127111
    Parameter type conflict error for setChar on in out parameter

BUG-4176026
    getCharacterStream() 1m byte(333334 chars) from long and got
    333416 chars

BUG-4092459
    Incomplete/incorrect login timeout support for getConnection
