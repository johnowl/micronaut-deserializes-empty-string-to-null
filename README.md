## Jackson serialization treat empty string value as null

The unit test `should return response with one value empty` fails, but it was expected to pass
because mock return an empty string for `value2`.

Mock response:

```
{
    "value1": "11111",
    "value2": ""
}
```