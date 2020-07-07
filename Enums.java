package hit.co.il;
public final class Enums
{
	public enum eProductType
	{
		Food(1),
		Medical(2),
		Administration(3);

		public static final int SIZE = java.lang.Integer.SIZE;

		private int intValue;
		private static java.util.HashMap<Integer, eProductType> mappings;
		private static java.util.HashMap<Integer, eProductType> getMappings()
		{
			if (mappings == null)
			{
				synchronized (eProductType.class)
				{
					if (mappings == null)
					{
						mappings = new java.util.HashMap<Integer, eProductType>();
					}
				}
			}
			return mappings;
		}

		private eProductType(int value)
		{
			intValue = value;
			getMappings().put(value, this);
		}

		public int getValue()
		{
			return intValue;
		}

		public static eProductType forValue(int value)
		{
			return getMappings().get(value);
		}
	}
}

