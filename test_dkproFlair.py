import unittest
import dkproFlair


class TestDkproFlair(unittest.TestCase):

    def test_casFlair(self):
        with open('flairNER.xmi', 'r', encoding='utf-8') as file:
            flairXMI = file.read()
        result = dkproFlair.casFlair("document.txt")
        self.assertEqual(result, flairXMI)

if __name__ == '__main__':
    unittest.main()