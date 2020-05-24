/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.jena.riot.thrift.wire;

@SuppressWarnings("all")
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-05-24")
public class RDF_PrefixName implements org.apache.thrift.TBase<RDF_PrefixName, RDF_PrefixName._Fields>, java.io.Serializable, Cloneable, Comparable<RDF_PrefixName> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RDF_PrefixName");

  private static final org.apache.thrift.protocol.TField PREFIX_FIELD_DESC = new org.apache.thrift.protocol.TField("prefix", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField LOCAL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("localName", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RDF_PrefixNameStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RDF_PrefixNameTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String prefix; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String localName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PREFIX((short)1, "prefix"),
    LOCAL_NAME((short)2, "localName");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PREFIX
          return PREFIX;
        case 2: // LOCAL_NAME
          return LOCAL_NAME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PREFIX, new org.apache.thrift.meta_data.FieldMetaData("prefix", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LOCAL_NAME, new org.apache.thrift.meta_data.FieldMetaData("localName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RDF_PrefixName.class, metaDataMap);
  }

  public RDF_PrefixName() {
  }

  public RDF_PrefixName(
    java.lang.String prefix,
    java.lang.String localName)
  {
    this();
    this.prefix = prefix;
    this.localName = localName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RDF_PrefixName(RDF_PrefixName other) {
    if (other.isSetPrefix()) {
      this.prefix = other.prefix;
    }
    if (other.isSetLocalName()) {
      this.localName = other.localName;
    }
  }

  public RDF_PrefixName deepCopy() {
    return new RDF_PrefixName(this);
  }

  @Override
  public void clear() {
    this.prefix = null;
    this.localName = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPrefix() {
    return this.prefix;
  }

  public RDF_PrefixName setPrefix(@org.apache.thrift.annotation.Nullable java.lang.String prefix) {
    this.prefix = prefix;
    return this;
  }

  public void unsetPrefix() {
    this.prefix = null;
  }

  /** Returns true if field prefix is set (has been assigned a value) and false otherwise */
  public boolean isSetPrefix() {
    return this.prefix != null;
  }

  public void setPrefixIsSet(boolean value) {
    if (!value) {
      this.prefix = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getLocalName() {
    return this.localName;
  }

  public RDF_PrefixName setLocalName(@org.apache.thrift.annotation.Nullable java.lang.String localName) {
    this.localName = localName;
    return this;
  }

  public void unsetLocalName() {
    this.localName = null;
  }

  /** Returns true if field localName is set (has been assigned a value) and false otherwise */
  public boolean isSetLocalName() {
    return this.localName != null;
  }

  public void setLocalNameIsSet(boolean value) {
    if (!value) {
      this.localName = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case PREFIX:
      if (value == null) {
        unsetPrefix();
      } else {
        setPrefix((java.lang.String)value);
      }
      break;

    case LOCAL_NAME:
      if (value == null) {
        unsetLocalName();
      } else {
        setLocalName((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PREFIX:
      return getPrefix();

    case LOCAL_NAME:
      return getLocalName();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case PREFIX:
      return isSetPrefix();
    case LOCAL_NAME:
      return isSetLocalName();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof RDF_PrefixName)
      return this.equals((RDF_PrefixName)that);
    return false;
  }

  public boolean equals(RDF_PrefixName that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_prefix = true && this.isSetPrefix();
    boolean that_present_prefix = true && that.isSetPrefix();
    if (this_present_prefix || that_present_prefix) {
      if (!(this_present_prefix && that_present_prefix))
        return false;
      if (!this.prefix.equals(that.prefix))
        return false;
    }

    boolean this_present_localName = true && this.isSetLocalName();
    boolean that_present_localName = true && that.isSetLocalName();
    if (this_present_localName || that_present_localName) {
      if (!(this_present_localName && that_present_localName))
        return false;
      if (!this.localName.equals(that.localName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetPrefix()) ? 131071 : 524287);
    if (isSetPrefix())
      hashCode = hashCode * 8191 + prefix.hashCode();

    hashCode = hashCode * 8191 + ((isSetLocalName()) ? 131071 : 524287);
    if (isSetLocalName())
      hashCode = hashCode * 8191 + localName.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(RDF_PrefixName other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetPrefix()).compareTo(other.isSetPrefix());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrefix()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.prefix, other.prefix);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetLocalName()).compareTo(other.isSetLocalName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLocalName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.localName, other.localName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("RDF_PrefixName(");
    boolean first = true;

    sb.append("prefix:");
    if (this.prefix == null) {
      sb.append("null");
    } else {
      sb.append(this.prefix);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("localName:");
    if (this.localName == null) {
      sb.append("null");
    } else {
      sb.append(this.localName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (prefix == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'prefix' was not present! Struct: " + toString());
    }
    if (localName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'localName' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RDF_PrefixNameStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RDF_PrefixNameStandardScheme getScheme() {
      return new RDF_PrefixNameStandardScheme();
    }
  }

  private static class RDF_PrefixNameStandardScheme extends org.apache.thrift.scheme.StandardScheme<RDF_PrefixName> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RDF_PrefixName struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PREFIX
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.prefix = iprot.readString();
              struct.setPrefixIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LOCAL_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.localName = iprot.readString();
              struct.setLocalNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, RDF_PrefixName struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.prefix != null) {
        oprot.writeFieldBegin(PREFIX_FIELD_DESC);
        oprot.writeString(struct.prefix);
        oprot.writeFieldEnd();
      }
      if (struct.localName != null) {
        oprot.writeFieldBegin(LOCAL_NAME_FIELD_DESC);
        oprot.writeString(struct.localName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RDF_PrefixNameTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RDF_PrefixNameTupleScheme getScheme() {
      return new RDF_PrefixNameTupleScheme();
    }
  }

  private static class RDF_PrefixNameTupleScheme extends org.apache.thrift.scheme.TupleScheme<RDF_PrefixName> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RDF_PrefixName struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.prefix);
      oprot.writeString(struct.localName);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RDF_PrefixName struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.prefix = iprot.readString();
      struct.setPrefixIsSet(true);
      struct.localName = iprot.readString();
      struct.setLocalNameIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

